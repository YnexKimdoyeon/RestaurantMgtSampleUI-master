package home;

import java.util.ArrayList;

public class SelectRoom {
    public ArrayList<String> PrintRoom(String Day , String Floor , String Place , int Time1 , int Time2 , int count) { //받을것 : 요일 , 시간 , 관?

        ArrayList<String> PrintRoomList = new ArrayList<>();
        DataBase Db = new DataBase();
        ArrayList<String> SelectRoomList = Db.PrintRoom(Place);
        for (String str : SelectRoomList) {

            String[] FirstListWithSpace = str.split(" ");
            String SelectForDay = FirstListWithSpace[0];

            String SelectTimeReplace = FirstListWithSpace[1].replace("교시", "");
            String[] SelectTimeList = SelectTimeReplace.split("-");
            String first = SelectTimeList[0];
            String second = SelectTimeList[1];

            String EqualsFloor = FirstListWithSpace[2].replace("호", "").replace("A", "").replace("B", "");

            if (Day.equals(SelectForDay)) {
                if ((Integer.parseInt(Floor) + 1) * 100 >= Integer.parseInt(EqualsFloor) && Integer.parseInt(EqualsFloor) > Integer.parseInt(Floor) * 100 || count == 1) {
                    if (Time1 >= Integer.parseInt(first) && Integer.parseInt(first) <= Time2) {

                        if (Time1 <= Integer.parseInt(second) && Integer.parseInt(second) >= Time2 ) {
                            PrintRoomList.add(FirstListWithSpace[2]);
                        }
                    }
                }
            }
        }
        return PrintRoomList;
    }
}
