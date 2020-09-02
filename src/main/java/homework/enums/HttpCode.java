package homework.enums;

public enum HttpCode {
    INFORMATIONAL(1){
        @Override
        void process() {
            System.out.println("Informational");
        }
    },
    SUCCESS(2) {
        @Override
        void process() {
            System.out.println("Success");
        }
    },
    REDIRECTION(3) {
        @Override
        void process() {
            System.out.println("Redirection");
        }
    },
    CLIENT_ERROR(4) {
        @Override
        void process() {
            System.out.println("Client error");
        }
    },
    SERVER_ERROR(5) {
        @Override
        void process() {
            System.out.println("Server error");
        }
    };


    public final int startNumber;

    HttpCode(int startNumber){
        this.startNumber = startNumber;
    }

    abstract void process();
}
