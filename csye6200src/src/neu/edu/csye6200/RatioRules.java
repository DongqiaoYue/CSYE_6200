package neu.edu.csye6200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RatioRules {

    private List<int[]> ageRanges;

    private List<Integer> studentCapacities;

    private List<Integer> groupCapacities;

    public RatioRules(){
        ageRanges = new ArrayList<>();
        studentCapacities = new ArrayList<>();
        groupCapacities = new ArrayList<>();
    }

    public void parseAndLoadRatioRules(List<String> ruleCSV){
        for (String str : ruleCSV){
            String[] strs = str.split(",");
            String[] str0 = strs[0].split("-");
            int[] range = new int[]{Integer.valueOf(str0[0]), Integer.valueOf(str0[1])};
            ageRanges.add(range);
            studentCapacities.add(Integer.valueOf(strs[1]));
            groupCapacities.add(Integer.valueOf(strs[3]));
        }
    }

    public int[] findRangeByAge(int age){
        for (int[] range : ageRanges) {
            if (age <= range[1] && age >= range[0]) {
                return range;
            }
        }
        return new int[]{0, 0};
    }

    public int getSCByRange(int[] rangeTarget){
        for (int i = 0 ; i < ageRanges.size(); i++){
            if (Arrays.equals(ageRanges.get(i), rangeTarget)){
                return studentCapacities.get(i);
            }
        }
        return -1;
    }

    public int getGCByRange(int[] rangeTarget){
        for (int i = 0 ; i < ageRanges.size(); i++){
            if (Arrays.equals(ageRanges.get(i), rangeTarget)){
                return groupCapacities.get(i);
            }
        }
        return -1;
    }

}
