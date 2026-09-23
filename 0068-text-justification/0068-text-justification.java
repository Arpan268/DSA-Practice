class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        int l = 0, r = 0, countspaces = 0, length = 0;

        while (r < words.length) {
            String s = words[r];
            length += s.length();

            if (length + countspaces > maxWidth) {
                StringBuilder sb = new StringBuilder();
                int totalspaces = maxWidth - (length - s.length());

                if (countspaces == 1) {
                    String spaces = "";
                    while (totalspaces > 0) {
                        spaces += " ";
                        totalspaces--;
                    }
                    sb.append(words[l]).append(spaces);
                }

                else if (totalspaces % (countspaces - 1) == 0) {
                    while (l < r - 1) {
                        String spaces = "";
                        int spacesrequired = totalspaces / (countspaces - 1);
                        while (spacesrequired > 0) {
                            spaces += " ";
                            spacesrequired--;
                        }
                        sb.append(words[l]).append(spaces);
                        l++;
                    }
                    sb.append(words[l]);
                }

                else if (totalspaces % (countspaces - 1) != 0) {
                    int extraspaces = totalspaces % (countspaces - 1);
                    while (l < r - 1) {
                        String spaces = "";
                        int spacesrequired = totalspaces / (countspaces - 1);
                        while (spacesrequired > 0) {
                            spaces += " ";
                            spacesrequired--;
                        }
                        if (extraspaces > 0) {
                            spaces += " ";
                            extraspaces--;
                        }
                        sb.append(words[l]).append(spaces);
                        l++;
                    }
                    sb.append(words[l]);
                }

                l++;
                countspaces = 0;
                length = s.length();
                list.add(sb.toString());
            }

            countspaces++;
            r++;
        }

        StringBuilder sb = new StringBuilder();
        countspaces = 0;
        length = 0;

        while (l < r) {
            String s = words[l];
            length += s.length();

            if (l + 1 == r) {
                int spacesrequired = maxWidth - (length + countspaces);
                String spaces = "";
                while (spacesrequired > 0) {
                    spaces += " ";
                    spacesrequired--;
                }
                sb.append(words[l]).append(spaces);
                break;
            }

            countspaces++;
            sb.append(words[l]).append(" ");
            l++;
        }
        list.add(sb.toString());

        return list;
    }
}