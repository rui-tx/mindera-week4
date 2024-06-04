package ioexercise;

public enum MenuEnum {
    EXIT(0, "0", "exit"),
    OP1A(1,"1", "askAndPrintUserDirToPrint()"),
    OP2A(2,"2", "askUserForFileAndPathAndSeeIfExists()"),
    OP2B(3,"3", "askUserForFileAndPathAndSeeIfExistsFull()"),
    OP3A(4,"5", "createNewFileInPath()"),
    OP3B(5,"5", "createNewFileInPathFull()");

    private int id;
    private String option;
    private String desc;

    MenuEnum(int id, String option, String desc) {
        this.id = id;
        this.option = option;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public String getOption() {
        return option;
    }

    public String getDesc() {
        return desc;
    }
}
