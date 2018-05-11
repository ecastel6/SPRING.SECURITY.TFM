package daos;

import entities.BooksEntity;

import java.util.List;

public interface BooksDao
{
    List<BooksEntity> list();

    List<BooksEntity> searchByAuthor(String authorName);
}
