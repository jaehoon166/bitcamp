package bitcamp.java100.ch10.ex1;

import bitcamp.java100.ch10.ex1.other.C;

public class Test1 {

    public static void main(String[] args) {
        // 1) 같은 패키지에 소속된 클래스 사용
        // => 따로 패키지명을 밝힐 필요는 없다.
        A obj = new A();

        // 2) 다른 패키지에 소속된 클래스인 경우 반드시 패키지명을 밝혀야 한다.
        // 그래야 컴파일러가 찾을 수 있다.
        // 컴파일 할 때 마다 클래스를 찾기 위해서 매번 전체 경로를 뒤질 수는 없지 않은가?
        //
        // "까짓거 요즘 컴 속도도 빠른데 그냥 찾게하면 안되겠나?"
        // => 문제는 같은 이름을 가진 클래스가 여러 패키지에 존재할 때
        // 그 중 어떤 패키지의 클래스를 말하는지 컴파일러가 모르기 때문이다.
        bitcamp.java100.ch10.ex1.other.B obj2 = new bitcamp.java100.ch10.ex1.other.B();

        // 이 클래스가 소속되어 있는 패키지의 하위 패키지니까
        // 패키지명을 지정할 때 그냥 하위 패키지명만 밝히면 안되나요?
        // => 안됩니다!
        // other.B obj3 = new other.B(); // 컴파일 오류!

        // 3) 다른 패키지에 소속된 클래스를 사용할 때 import를 이용하여
        // 미리 패키지를 밝히는 경우,
        C obj4 = new C();

        // 4) 다른 패키지에 소속된 클래스를 사용하려 할 때
        // 그 클래스가 공개되어야만 가능하다.
        // => D 클래스는 패키지 안에서만 사용되도록 비공개이기 때문에
        /// 다른 패키지에서 사용할 수 없다.
        // bitcamp.java100.ch10.ex1.other.D obj5 =
        // new bitcamp.java100.ch10.ex1.other.D(); // 컴파일 오류!

        // 4) 한 소스 파일에 여러 개의 패키지 멤버 클래스를 정의할 수 있다.
        F obj6 = new F();
        G obj7 = new G();

    }

}