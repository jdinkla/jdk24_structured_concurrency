class CustomScope<T> extends StructuredTaskScope<T> {
    private final Queue<T> results = new ConcurrentLinkedQueue<>();
    private final Queue<Throwable> exceptions = new ConcurrentLinkedQueue<>();

    @Override
    protected void handleComplete(Subtask<? extends T> subtask) {
        switch (subtask.state()) {
            case SUCCESS -> results.add(subtask.get());
            case FAILED -> exceptions.add(subtask.exception());
        }
    }

    void show() {
        println("results " + results);
        println("exceptions " + exceptions);
    }
}

void main() throws InterruptedException {
    try (var scope = new CustomScope<>()) {
        Stream.of(1, 2, 3, 4, 5).forEach((id) -> scope.fork( () -> task(id)));
        scope.join();
        scope.show();
    }
}

int task(int id) {
    if (id % 2 == 0) {
        throw new RuntimeException(id + " is even");
    }
    return id;
}
