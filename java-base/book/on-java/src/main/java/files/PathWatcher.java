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
public class PathWatcher {
    static Path test = Paths.get("test");

    static void delTxtFiles() {
        try {
            Files.walk(test).filter(f -> f.toString().endsWith(".txt")).forEach(f -> {
                System.out.println("deleting " + f);
                try {
                    Files.delete(f);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
                Directories.refreshTestDir();
                Directories.populateTestDir();
                Files.createFile(test.resolve("Hello.txt"));
                WatchService watcher = FileSystems.getDefault().newWatchService();
                test.register(watcher, ENTRY_DELETE);
                ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
                executorService.schedule(PathWatcher::delTxtFiles, 250, TimeUnit.MILLISECONDS);
                executorService.shutdown();
                WatchKey key = watcher.take();
                for (WatchEvent<?> pollEvent : key.pollEvents()) {
                    System.out.println("evt.context" + pollEvent.context() +
                            "\nevt.count()"+ pollEvent.count() +
                            "\nevt.kind()" + pollEvent.kind());
                }
    }
}
