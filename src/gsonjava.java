import java.awt.List;

import com.google.gson.Gson;

public class gsonjava {
		public static void main(String[] args) {
			/*String json = "[{\"aaa\":123,\"bbb\":456},{\"aaa\":789,\"bbb\":987}]";
			Gson gson = new Gson();
			List list = gson.fromJson(json,List.class);*/
			 int[] numbers = {1, 1, 2, 3, 5, 8, 13};
		     String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
		     Gson gson = new Gson();
		     String jsonnum = gson.toJson(numbers);
		     String jsonday = gson.toJson(days);
		     System.out.println(jsonnum);
		     System.out.println(jsonday);
		     int[] exceptjson = gson.fromJson(jsonnum, int[].class);
		     for(int i=0;i<exceptjson.length;i++){
		    	 System.out.print(exceptjson[i]+"");
		     }
		     System.out.println("");
		     String[] week = gson.fromJson(jsonday, String[].class);
		     for (int i = 0; i < week.length; i++) {
		    	 System.out.print(week[i]+"");
			}
		     System.out.println("");
		     
		}
}
