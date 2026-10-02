class TimeMap {

    HashMap<String, ArrayList<Record>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            map.put(key, new ArrayList<Record>());
        }

        map.get(key).add(new Record(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) {
            return "";
        }

        ArrayList<Record> list = map.get(key);
        int l = 0, r = list.size() - 1, i = -1;

        if(timestamp > list.get(r).timestamp) {
            return list.get(r).value;
        }
        else if(timestamp < list.get(l).timestamp) {
            return "";
        }

        while(l <= r) {
            int mid = l + (r - l) / 2;

            if(list.get(mid).timestamp == timestamp) {
                i = mid;
                break;
            }
            else if(list.get(mid).timestamp < timestamp) {
                l = mid + 1;
            }
            else if(list.get(mid).timestamp > timestamp) {
                r = mid - 1;
            }
        }

        if(i == -1) {
            return list.get(r).value;
        }

        return list.get(i).value;
    }

    class Record {
        int timestamp;
        String value;
        
        public Record(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */