import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface ISignUp {
    // 打印输出结果
    public void print();
// 检查是否有 stuType对应的班级名额
// 如果没有剩余名额，请返回 false ，否则学生将报名进入该班级并返回 true
     public boolean addStudent (int stuType);
// 解析命令行输入的参数（格式），如文档描述
   public static  IParams parse() throws Exception { // 调用静态方法

       Scanner scanner = new Scanner(System.in);
       String s1 = scanner.nextLine();
       SchoolSystem AA = new SchoolSystem();
       String ss[] = AA.parse(s1);

       String s2 = scanner.nextLine(); // 输入字符串
       s2 = s2.substring(2,s2.length()-2); //前后二个字符


       String[] s3;                    //[[1, 1, 0], [1], [2], [3], [1]]
       s3 = s2.split("], ");
       if(ss.length != s3.length){ // 对应的操作都有值
           return null;
       }
       //System.out.println("dddd");

       if (!ss[0].equals("\"SchoolSystem\"") || s3[0].length() == 2) {
                return null;
       } else {
           int big = 1;
           int medium  = 1;
           int small  = 1;
           ArrayList<Integer> arrayList = new ArrayList<>();
           //解析字符串
           for(int i = 0;i < s3.length;i++){
           if(i == 0){//1, 1, 0  [100, 5000, 0]
               String[] str = s3[0].split(", ");
               if(str.length != 3){
                   return null;
               }else{
                   big = Integer.parseInt(str[0]);
                   medium = Integer.parseInt(str[1]);
                   small = Integer.parseInt(str[2]);
               }
           }
           else{
               int size = s3[i].length();
               s3[i] = s3[i].substring(1,size);
               arrayList.add(Integer.parseInt(s3[i]));
           }
       }

           int finalBig = big;
           int finalMedium = medium;
           int finalSmall = small;
           IParams s = new IParams() {

               @Override
               public int getBig() {
            /*   System.out.println("请您输入n:");
               list.add("SchoolSystem");
               list.add("addStudent");
               list.add("addStudent");
               list.add("addStudent");
               list.add("addStudent");
               for (int i = 0; i < list.size(); i++) {
                   String[] arr = AA.parse(list.get(i));
                   if (i == 0) {
                       big = Integer.parseInt(arr[0]);
                       medium = Integer.parseInt(arr[1]);
                       small = Integer.parseInt(arr[2]);
                   } else {
                       arrayList.add(Integer.parseInt(arr[0]));
                   }
               }*/
                   //System.out.println(big);
                   return finalBig;
               }

               @Override
               public int getMedium() {
                   return finalMedium;
               }

               @Override
               public int getSmall() {
                   return finalSmall;
               }

               @Override
               public ArrayList<Integer> getPlanSignUp() {

                   return arrayList;
               }
           };
           return s;
       }
   }
}