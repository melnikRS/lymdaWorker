public class Worker {
    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;
    private static final int ERROR_NUMBER_TASK = 33;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }

    @FunctionalInterface
    public interface OnTaskErrorListener {
        void onError(String result);
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i != ERROR_NUMBER_TASK)
                callback.onDone("Task " + i + " is done");
            else
                errorCallback.onError("Task " + i + " is error");
        }
    }

}
