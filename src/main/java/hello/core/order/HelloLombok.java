package hello.core.order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class HelloLombok {
    private String  name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("hello");
        helloLombok.setAge(20);

        System.out.println("helloLombok.getName() = " + helloLombok.getName());
        System.out.println("helloLombok=" + helloLombok);
    }
}
