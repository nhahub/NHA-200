package Utilities;

import java.util.List;

public class CommandsUtility {
    public static List<String> windowsCommand(String browserName, String filePath) {
        return switch (browserName.toLowerCase()) {
            case "firefox" -> List.of("cmd", "/c", "start", "firefox", filePath);
            case "edge" -> List.of("cmd", "/c", "start", "msedge", filePath);
            default -> List.of("cmd", "/c", "start", "chrome", filePath);

        };
    }

    public static List<String> macCommand(String browserName, String filePath) {
        return switch (browserName.toLowerCase()) {
            case "edge" -> List.of("open", "-a", "Microsoft Edge", filePath);
            case "firefox" -> List.of("open", "-a", "Firefox", filePath);
            default -> List.of("open", "-a", "Google Chrome", filePath);
        };
    }

    public static List<String> linuxCommand(String browserName, String filePath) {
        return switch (browserName.toLowerCase()) {
            case "firefox" -> List.of("firefox", filePath);
            case "edge" -> List.of("microsoft-edge", filePath);
            default -> List.of("google-chrome", filePath);

        };
    }
}

