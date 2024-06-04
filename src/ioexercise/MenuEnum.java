package ioexercise;

public enum MenuEnum {
    EXIT(0, "0", "exit"),
    OP1A(1,"1", "List files of a directory"),
    OP2A(2,"2", "Check if a file / directory exists - Absolute / Relative paths"),
    OP2B(3,"3", "Check if a file / directory exists - Absolute paths"),
    OP3A(4,"5", "Create new file in a path with custom name - Absolute / Relative paths"),
    OP3B(5,"5", "Create new file in a path with custom name - Absolute paths");

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
