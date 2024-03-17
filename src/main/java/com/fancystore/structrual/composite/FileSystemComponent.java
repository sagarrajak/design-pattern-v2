package com.fancystore.structrual.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class FileSystemComponent {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    protected FileSystemComponent(String name) {
        this.name = name;
    }

    abstract  public  int getSize();
    abstract  public  String printStructur();
}



class File extends FileSystemComponent {

    public File(String name) {
        super(name);
    }

    @Override
    public int getSize() {
        return 1;
    }

    @Override
    public String printStructur() {
        return this.getName()+"\n";
    }
}

class Directory extends FileSystemComponent {
    private List<FileSystemComponent> subFiles = new ArrayList<>();

    public Directory(String name) {
        super(name);
    }

    public void addFile(FileSystemComponent file) {
        subFiles.add(file);
    }

    public void deleteFile(int idx) {
        if (idx >=0 && idx < subFiles.size())
            subFiles.remove(idx);
    }

    @Override
    public int getSize() {
        return this.subFiles.stream().map(FileSystemComponent::getSize).mapToInt(Integer::intValue).sum();
    }

    public String addTabBeforeLines(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] lines = input.split("\\r?\\n");
        for (String line : lines) {
            stringBuilder.append("\t").append(line).append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String printStructur() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getName());
        builder.append("\n");
        for (var child: subFiles) {
            builder.append("\t");
            builder.append(addTabBeforeLines(child.printStructur()));
        }
        return builder.toString();
    }
}

class  Main {
    public static void main(String[] args) {
        Directory test = new Directory("test");
        Directory dir = new Directory("dir 2");

        File file = new File("file 1");
        File file1 = new File("file 2");
        File file2 = new File("file 3");

        test.addFile(file);
        test.addFile(file2);
        test.addFile(file1);
        test.addFile(dir);

        dir.addFile(new File("file 4"));
        dir.addFile(new File("file 5"));
        dir.addFile(new File("file 6"));
        dir.addFile(new Directory("dir 3"));

        System.out.println(test.printStructur());

    }
}