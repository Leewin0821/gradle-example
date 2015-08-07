package model;

public class ToDoItem
{
    private Long id;
    private String name;
    private boolean completed;

    public ToDoItem(Long id, String name, boolean completed)
    {
        this.id = id;
        this.name = name;
        this.completed = completed;
    }

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
}
