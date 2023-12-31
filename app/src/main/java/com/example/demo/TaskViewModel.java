package com.example.demo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskViewModel extends ViewModel {
    private MutableLiveData<List<TaskItem>> taskItems = new MutableLiveData<>();

    public TaskViewModel() {
        taskItems.setValue(new ArrayList<>());
    }

    public MutableLiveData<List<TaskItem>> getTaskItems() {
        return taskItems;
    }

    public void addTaskItem(TaskItem newTask) {
        List<TaskItem> list = taskItems.getValue();
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(newTask);
        taskItems.postValue(list);
    }

    public void updateTaskItem(UUID id, String name, String desc, LocalTime dueTime) {
        List<TaskItem> list = taskItems.getValue();
        if (list != null) {
            for (TaskItem task : list) {
                if (task.getId().equals(id)) {
                    task.setName(name);
                    task.setDesc(desc);
                    task.setDueTime(dueTime);
                    break;
                }
            }
            taskItems.postValue(list);
        }
    }

    public void setCompleted(TaskItem taskItem) {
        List<TaskItem> list = taskItems.getValue();
        if (list != null) {
            for (TaskItem task : list) {
                if (task.getId().equals(taskItem.getId())) {
                    if (task.getCompletedDate() == null) {
                        task.setCompletedDate(LocalDate.now());
                    }
                    break;
                }
            }
            taskItems.postValue(list);
        }
    }
}