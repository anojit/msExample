/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package mdemo;

import com.socielo.messaging.MsgBroker;

import static com.socielo.messaging.MsgBroker.getBroker;

public class App {
    public static void main(String[] args) {
        final MsgBroker broker = new MsgBroker(getBroker(), "Square");
        broker.subscribe("square", (topic, data) -> {
            try {
                double num = Double.parseDouble(data);

                broker.publish("squared", String.valueOf(num * num));
            } catch(NumberFormatException nan) {
                System.out.printf("Topic: %s%nData: %s is NOT a number%n", topic, data);
            }

        });
        System.out.println("Started Square microservice");
    }
}
