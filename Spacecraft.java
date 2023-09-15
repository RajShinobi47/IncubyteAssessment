public class Spacecraft {
    private int x;
    private int y;
    private int z;
    private String direction;
    private String prevDirection;

    public Spacecraft(int x, int y, int z, String direction) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.direction = direction;
        this.prevDirection = "";
    }

    public void moveForward() {
        if (direction.equals("N")) {
            y++;
        } else if (direction.equals("S")) {
            y--;
        } else if (direction.equals("E")) {
            x++;
        } else if (direction.equals("W")) {
            x--;
        } else if (direction.equals("Up")) {
            z++;
        } else if (direction.equals("Down")) {
            z--;
        }
    }

    public void moveBackward() {
        if (direction.equals("N")) {
            y--;
        } else if (direction.equals("S")) {
            y++;
        } else if (direction.equals("E")) {
            x--;
        } else if (direction.equals("W")) {
            x++;
        } else if (direction.equals("Up")) {
            z--;
        } else if (direction.equals("Down")) {
            z++;
        }
    }

    public void turnLeft() {
        if (direction.equals("N")) {
            direction = "W";
        } else if (direction.equals("S")) {
            direction = "E";
        } else if (direction.equals("E")) {
            direction = "N";
        } else if (direction.equals("W")) {
            direction = "S";
        } else if (direction.equals("Up")) {
            if (prevDirection.equals("N")) {
                direction = "W";
            } else if (prevDirection.equals("S")) {
                direction = "E";
            } else if (prevDirection.equals("E")) {
                direction = "N";
            } else if (prevDirection.equals("W")) {
                direction = "S";
            }
        } else if (direction.equals("Down")) {
            if (prevDirection.equals("N")) {
                direction = "W";
            } else if (prevDirection.equals("S")) {
                direction = "E";
            } else if (prevDirection.equals("E")) {
                direction = "N";
            } else if (prevDirection.equals("W")) {
                direction = "S";
            }
        }
    }

    public void turnRight() {
        if (direction.equals("N")) {
            direction = "E";
        } else if (direction.equals("S")) {
            direction = "W";
        } else if (direction.equals("E")) {
            direction = "S";
        } else if (direction.equals("W")) {
            direction = "N";
        } else if (direction.equals("Up")) {
            if (prevDirection.equals("N")) {
                direction = "E";
            } else if (prevDirection.equals("S")) {
                direction = "W";
            } else if (prevDirection.equals("E")) {
                direction = "S";
            } else if (prevDirection.equals("W")) {
                direction = "N";
            }
        } else if (direction.equals("Down")) {
            if (prevDirection.equals("N")) {
                direction = "E";
            } else if (prevDirection.equals("S")) {
                direction = "W";
            } else if (prevDirection.equals("E")) {
                direction = "S";
            } else if (prevDirection.equals("W")) {
                direction = "N";
            }
        }
    }

    public void turnUp() {
        prevDirection = direction;
        if (direction.equals("N")) {
            direction = "Up";
        } else if (direction.equals("S")) {
            direction = "Down";
        } else if (direction.equals("E")) {
            direction = "Up";
        } else if (direction.equals("W")) {
            direction = "Up";
        } else if (direction.equals("Up")) {
            direction = "Up";
        } else if (direction.equals("Down")) {
            direction = "Up";
        }
    }

    public void turnDown() {
        prevDirection = direction;
        if (direction.equals("N")) {
            direction = "Down";
        } else if (direction.equals("S")) {
            direction = "Down";
        } else if (direction.equals("E")) {
            direction = "Down";
        } else if (direction.equals("W")) {
            direction = "Down";
        } else if (direction.equals("Up")) {
            direction = "Down";
        } else if (direction.equals("Down")) {
            direction = "Down";
        }
    }

    public void executeCommands(String commands) {
        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'f':
                    moveForward();
                    break;
                case 'b':
                    moveBackward();
                    break;
                case 'l':
                    turnLeft();
                    break;
                case 'r':
                    turnRight();
                    break;
                case 'u':
                    turnUp();
                    break;
                case 'd':
                    turnDown();
                    break;
                default:
                    // Ignore invalid commands
                    break;
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public String getDirection() {
        return direction;
    }

    public static void main(String[] args) {
        Spacecraft spacecraft = new Spacecraft(0, 0, 0, "N");
        String commands = "frubl";

        spacecraft.executeCommands(commands);

        System.out.println("Final Position: (" + spacecraft.getX() + ", " + spacecraft.getY() + ", " + spacecraft.getZ() + ")");
        System.out.println("Final Direction: " + spacecraft.getDirection());
    }
}
