void main() {
    try (var scope = new StructuredTaskScope.ShutdownOnSuccess<>()) {
        scope.fork(this::fetchFromCache);
        scope.fork(this::fetchFromDatabase);
        scope.join();
        println("Result: " + scope.result());
    } catch (InterruptedException | ExecutionException e) {
        println("Exception " + e);
    }
}

int fetchFromCache() throws InterruptedException {
    println("Start fetchFromCache");
    Thread.sleep(100L);
    println("End fetchFromCache");
    return 1;
}

int fetchFromDatabase() throws InterruptedException {
    println("Start fetchFromDatabase");
    Thread.sleep(250L);
    println("End fetchFromDatabase");
    return 1;
}
