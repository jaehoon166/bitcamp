package controll;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import domain.Room;
import utill.App;
import utill.Prompts;

public class RoomController extends ArrayList<Room> {

    Scanner keyScan = new Scanner(System.in);
    
    public void excute() {
        loop: while (true) {
            System.out.print("강의실관리> ");
            String input = keyScan.nextLine().toLowerCase();
            switch (input) {
            case "add":
                this.doAdd();
                break;

            case "list":
                this.doList();
                break;

            case "delete":
                this.doDelete();
                break;

            case "main":
                break loop;

            default:
                App.doError();
            }
            System.out.println();
        }
    }

    private void doDelete() {
        System.out.println("[강의실 삭제]");
        String roomName = Prompts.inputString("강의실 이름? ");

        Room room = find(roomName);

        if (room == null) {
            System.out.printf("'%s'의 강의실 정보가 없습니다.\n", roomName);
            return;
        }

        if (Prompts.confirm2("정말 삭제하시겠습니까?(y/N) ")) {
            this.remove(room);
            System.out.println("삭제하였습니다.");
        } else {
            System.out.println("삭제를 취소하였습니다.");
        }
    }

    private void doAdd() {
        System.out.println("[강의실 등록]");
        Room room = new Room();

        room.setName(Prompts.inputString("이름? "));
        if (find(room.getName()) != null) {
            System.out.println("이미 등록된 강의실입니다.");
            return;
        }

        room.setLocation(Prompts.inputString("지역? "));
        room.setCapacity(Prompts.inputInt("수용인원? "));

        this.add(room);
    }

    private void doList() {
        System.out.println("[강의실 목록]");

        Iterator<Room> iterator = this.iterator();
        while (iterator.hasNext()) {
            Room room = iterator.next();
            System.out.printf("%-4s, %s\n", room.getName(), room.getCapacity());
        }
    }

    private Room find(String roomName) {
        Iterator<Room> iterator = this.iterator();
        while (iterator.hasNext()) {
            Room room = iterator.next();
            if (room.getName().equals(roomName)) {
                return room;
            }
        }
        return null;
    }
}
