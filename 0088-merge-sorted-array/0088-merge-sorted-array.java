class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = m - 1, r = nums1.length - 1, track = nums2.length - 1;

        while(l > -1 && track > -1) {
            if(nums1[l] > nums2[track]) {
                nums1[r] = nums1[l];
                r--;
                l--;
            }
            else if(nums1[l] < nums2[track]) {
                nums1[r] = nums2[track];
                r--;
                track--;
            }
            else if(nums1[l] == nums2[track]) {
                nums1[r] = nums2[track];
                r--;
                track--;
            }
        }

        int i = 0;

        while(l != r && i <= track) {
            l++;
            nums1[l] = nums2[i];
            i++;
        }
    }
}