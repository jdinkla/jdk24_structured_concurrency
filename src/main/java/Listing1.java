import java.util.concurrent.StructuredTaskScope.Subtask;

void main() {
    try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
        Subtask<String> a = scope.fork(this::task);
        Subtask<String> b = scope.fork(this::task);
        scope.join();
        println("Result: " + a.get() + ", " + b.get());
    } catch (InterruptedException e) {
        println("Exception " + e);
    }
}

String task() throws InterruptedException {
    Thread.sleep(500);
    return Thread.currentThread().toString();
}
