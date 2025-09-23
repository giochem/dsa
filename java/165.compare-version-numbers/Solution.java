class Solution {
    public int compareVersion(String version1, String version2) {
        String[] revisions1 = version1.split("\\.");
        String[] revisions2 = version2.split("\\.");
        int i = 0;
        int j = 0;
        int compareVersion = 0;
        while (i < revisions1.length || j < revisions2.length) {
            if (i < revisions1.length && j < revisions2.length) {
                System.out.println(Integer.parseInt(revisions1[i]) + " " + Integer.parseInt(revisions2[j]));
                int compare = Integer.compare(Integer.parseInt(revisions1[i]), Integer.parseInt(revisions2[j]));
                if (compare == 0) {
                    i++;
                    j++;
                } else {
                    compareVersion = compare;
                    break;
                }
            }
            if (i < revisions1.length) {
                int compare = Integer.compare(Integer.parseInt(revisions1[i]), 0);
                if (compare == 0) {
                    i++;
                } else {
                    compareVersion = compare;
                    break;
                }
            }
            if (j < revisions2.length) {
                int compare = Integer.compare(0, Integer.parseInt(revisions2[j]));
                if (compare == 0) {
                    j++;
                } else {
                    compareVersion = compare;
                    break;
                }
            }
        }
        return compareVersion;
    }
}