import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SchoolSystem implements ISignUp {
        int big;   //1
        int medium; // 2
        int small; // 3
    public SchoolSystem(){}
    public SchoolSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }
    static Scanner s = new  Scanner(System.in);
    static List<Object> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {

        IParams params = ISignUp.parse();//SchoolSystem.parse();
        if (params == null) {
            System.out.println("输入错误");
        } else {


            SchoolSystem sc = new SchoolSystem(params.getBig(), params.getMedium(), params.getSmall());
            list.add(null);

            ArrayList<Integer> plan = params.getPlanSignUp(); //   "SchoolSystem","addStudent", "addStudent", "addStudent", "addStudent"] list .size()
            System.out.println(plan);
            for (int i = 0; i < plan.size(); i++) {           //    [[1, 1, 0],           [1], [2], [3], [1]]    [ 1 1 0] string
                list.add(sc.addStudent(plan.get(i)));     //    [null, true, true, false, false]
            }
            sc.print();
        }
    }
    @Override
    public void print() {
        System.out.println(list);
    }

    @Override
    public boolean addStudent(int stuType) {
        if(stuType == 1){
            if(big > 0){
                big--;
            }
            else{
                return false;
            }
        }else if(stuType == 2){
            if(medium > 0){
                medium--;
            }else{
                return false;
            }
        }if(stuType == 3){
            if(small > 0){
                small--;
            }else{
                return false;
            }
        }
        return true;
    }

    public String[]  parse(String s1) {

        s1 = s1.substring(1,s1.length()-1);
        String ss[] = s1.split(",");
        return ss;
    }
}
