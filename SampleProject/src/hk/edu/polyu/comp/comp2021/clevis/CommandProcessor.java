package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.model.ShapeManager;

/**
 * Controller: Parses user input and calls appropriate ShapeManager methods
 * Returns true only if command executed successfully (for logging)
 */
public class CommandProcessor {

    public static boolean execute(String rawCommand, ShapeManager manager) {
        if (rawCommand == null || rawCommand.trim().isEmpty()) return false;

        String[] tokens = rawCommand.trim().split("\\s+");
        String cmd = tokens[0].toLowerCase();

        try {
            switch (cmd) {
                case "rectangle" -> {
                    checkArgs(tokens, 7);
                    ShapeManager.createRectangle(tokens[1],
                            Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]),
                            Double.parseDouble(tokens[4]), Double.parseDouble(tokens[5]));
                }
                case "line" -> {
                    checkArgs(tokens, 7);
                    ShapeManager.createLine(tokens[1],
                            Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]),
                            Double.parseDouble(tokens[4]), Double.parseDouble(tokens[5]));
                }
                case "circle" -> {
                    checkArgs(tokens, 6);
                    ShapeManager.createCircle(tokens[1],
                            Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]),
                            Double.parseDouble(tokens[4]));
                }
                case "square" -> {
                    checkArgs(tokens, 6);
                    ShapeManager.createSquare(tokens[1],
                            Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]),
                            Double.parseDouble(tokens[4]));
                }
                case "group" -> ShapeManager.group(rawCommand);           // pass full command for parsing
                case "ungroup" -> {
                    checkArgs(tokens, 2);
                    ShapeManager.ungroup(tokens[1]);
                }
                case "delete" -> {
                    checkArgs(tokens, 2);
                    ShapeManager.delete(tokens[1]);
                }
                case "move" -> {
                    checkArgs(tokens, 4);
                    ShapeManager.move(tokens[1],
                            Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
                }
                case "boundingbox" -> {
                    checkArgs(tokens, 2);
                    double[] box = ShapeManager.getBoundingBox(tokens[1]);
                    System.out.printf("%.2f %.2f %.2f %.2f%n", box[0], box[1], box[2], box[3]);
                    return false;  // Query command → not logged
                }
                case "intersect" -> {
                    checkArgs(tokens, 3);
                    System.out.println(ShapeManager.intersect(tokens[1], tokens[2]));
                    return false;
                }
                case "shapeat" -> {
                    checkArgs(tokens, 3);
                    System.out.println(ShapeManager.shapeAt(
                            Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2])));
                    return false;
                }
                case "list" -> {
                    checkArgs(tokens, 2);
                    System.out.println(ShapeManager.listShape(tokens[1]));
                    return false;
                }
                case "listall" -> {
                    System.out.println(ShapeManager.listAll());
                    return false;
                }
                case "quit" -> System.exit(0);
                default -> {
                    System.out.println("Unknown command: " + cmd);
                    return false;
                }
            }
            return true;  // Success → will be logged in Application.java
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    private static void checkArgs(String[] tokens, int expected) {
        if (tokens.length != expected) {
            throw new IllegalArgumentException("Expected " + (expected - 1) + " arguments for command '" + tokens[0] + "'");
        }
    }
}