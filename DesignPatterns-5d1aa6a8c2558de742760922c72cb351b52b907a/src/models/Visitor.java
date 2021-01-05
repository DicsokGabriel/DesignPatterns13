package models;

public interface Visitor {

    void visit(Section s);
    void visit(Paragraph p);
    void visit(ImageProxy ip);
    void visit(Image i);
    void visit(Table t);
    void visit(Book b);

}
