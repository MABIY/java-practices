package files;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;

/**
 * @author lh
 */
public class TreeWatcher {
    static void watchDir(Path dir) {
        try {
            WatchService watcher = FileSystems.getDefault().newWatchService();
            dir.register(watcher,ENTRY_DELETE);
            ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
            scheduledExecutorService.submit(() -> {
                try {
                    WatchKey key = watcher.take();
                    for (WatchEvent<?> pollEvent : key.pollEvents()) {
                        System.out.println("evt.context" + pollEvent.context() + "\nevt.count()"
                                + pollEvent.count() + "\nevt.kind()"
                                + pollEvent.kind());
                    }
                } catch (InterruptedException ignored) {
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        Directories.refreshTestDir();
        Directories.populateTestDir();
        Files.walk(Paths.get("test"))
                .peek(System.out::println)
                .filter(Files::isDirectory)
                .forEach(TreeWatcher::watchDir);
        PathWatcher.delTxtFiles();

    }
}
