package repository;

import model.ToDoItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import com.google.common.collect.Lists;

public class InMemoryToDoRepository implements ToDoRepository
{
    private AtomicLong currentId = new AtomicLong();
    private ConcurrentHashMap<Long, ToDoItem> toDos = new ConcurrentHashMap<Long, ToDoItem>();

    @Override
    public List<ToDoItem> findAll()
    {
        ArrayList<ToDoItem> toDoItems = Lists.newArrayList(toDos.values());
        Collections.sort(toDoItems);
        return toDoItems;
    }

    @Override
    public ToDoItem findById(Long id)
    {
        return toDos.get(id);
    }

    @Override
    public Long insert(ToDoItem toDoItem)
    {
        long nextId = currentId.incrementAndGet();
        toDoItem.setId(nextId);
        toDos.putIfAbsent(nextId, toDoItem);
        return nextId;
    }

    @Override
    public void update(ToDoItem toDoItem)
    {
        toDos.replace(toDoItem.getId(), toDoItem);
    }

    @Override
    public void delete(ToDoItem toDoItem)
    {
        toDos.remove(toDoItem.getId());
    }
}
