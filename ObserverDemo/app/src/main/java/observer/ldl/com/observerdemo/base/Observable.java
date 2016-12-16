package observer.ldl.com.observerdemo.base;

/**
 * Created by ${ldl} on 2016/12/16.
 */
public interface Observable<T> {
    /**
     * 添加观察者
     * @param observer
     */
     void addObserver(Observer observer);

    /**
     * 删除观察者
      * @param observer
     */
    void deleteObserver(Observer observer);
    void notifyObserver(T obj,int flag);
}
