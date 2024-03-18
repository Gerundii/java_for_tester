package my.pack.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Groups extends ForwardingSet<GroupData> {

    private Set<GroupData> delegate;
    public Groups () {
        this.delegate = new HashSet<GroupData>();
    }

    //Конструктор для копирования объекта, передаваемого в качестве аргумента
    //В переменную delegate создаваемого объекта класса Groups, сохраняется HashSet,
    //который создан на основе HashSet, хранящегося в переменной delegate объекта, переданного в метод в качестве аргумента
    public  Groups (Groups groups) {
        this.delegate = new HashSet<GroupData>(groups.delegate);
    }

    public Groups(Collection<GroupData> groups) {
        this.delegate = new HashSet<GroupData>(groups);
    }

    @Override
    protected Set<GroupData> delegate() {
        return delegate;
    }

    //В качестве аргумента в метод передается объект класса GroupData
    public Groups withAdded (GroupData group) {
        //В переменную groups класса Groups сохраняем копию объекта, у которого был вызван данный метод, используя пользовательский конструктор
        Groups groups = new Groups(this);
        //Добавляем к созданной копии новую группу
        groups.add(group);
        //Возвращаем копию объекта, у которого был вызван метод, с добавленной в него новой группой 
        return groups;
    }

    public Groups without (GroupData group) {
        Groups groups = new Groups(this);
        groups.remove(group);
        return groups;
    }
}
