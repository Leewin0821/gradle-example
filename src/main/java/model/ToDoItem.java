package model;

import static com.google.common.base.Preconditions.checkNotNull;

public class ToDoItem implements Comparable<ToDoItem>
{
    private Long id;
    private String name;
    private boolean completed;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public boolean isCompleted()
    {
        return completed;
    }

    public void setCompleted(boolean completed)
    {
        this.completed = completed;
    }

    @Override
    public int compareTo(ToDoItem compared)
    {
        checkNotNull(compared);
        Long currentId = this.getId();
        Long comparedId = compared.getId();
        if (currentId > comparedId) {
            return 1;
        } else if (currentId < comparedId) {
            return -1;
        } else {
            return 0;
        }
    }
}
