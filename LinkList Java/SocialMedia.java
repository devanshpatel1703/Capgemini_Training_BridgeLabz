import java.util.Scanner;

class FriendNode {
    int friendId;
    FriendNode next;

    FriendNode(int friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}

class UserNode {
    int userId;
    String name;
    int age;
    FriendNode friendHead;
    UserNode next;

    UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendHead = null;
        this.next = null;
    }
}

class SocialMediaLinkedList {
    UserNode head;

    SocialMediaLinkedList() {
        this.head = null;
    }

    void addUser(int userId, String name, int age) {
        UserNode newUser = new UserNode(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            UserNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newUser;
        }
    }

    UserNode findUser(int userId, String name) {
        UserNode current = head;
        while (current != null) {
            if ((userId != 0 && current.userId == userId) || (name != null && current.name.equalsIgnoreCase(name))) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    void addFriend(int userId1, int userId2) {
        UserNode user1 = findUser(userId1, null);
        UserNode user2 = findUser(userId2, null);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        FriendNode newFriend1 = new FriendNode(userId2);
        newFriend1.next = user1.friendHead;
        user1.friendHead = newFriend1;

        FriendNode newFriend2 = new FriendNode(userId1);
        newFriend2.next = user2.friendHead;
        user2.friendHead = newFriend2;
    }

    void removeFriend(int userId1, int userId2) {
        UserNode user1 = findUser(userId1, null);
        UserNode user2 = findUser(userId2, null);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        FriendNode prev = null;
        FriendNode current = user1.friendHead;
        while (current != null) {
            if (current.friendId == userId2) {
                if (prev == null) {
                    user1.friendHead = current.next;
                } else {
                    prev.next = current.next;
                }
                break;
            }
            prev = current;
            current = current.next;
        }

        prev = null;
        current = user2.friendHead;
        while (current != null) {
            if (current.friendId == userId1) {
                if (prev == null) {
                    user2.friendHead = current.next;
                } else {
                    prev.next = current.next;
                }
                break;
            }
            prev = current;
            current = current.next;
        }
    }

    void displayFriends(int userId) {
        UserNode user = findUser(userId, null);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        FriendNode current = user.friendHead;
        System.out.print("Friends of " + user.name + ": ");
        while (current != null) {
            System.out.print(current.friendId + " ");
            current = current.next;
        }
        System.out.println();
    }

    void findMutualFriends(int userId1, int userId2) {
        UserNode user1 = findUser(userId1, null);
        UserNode user2 = findUser(userId2, null);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        FriendNode current1 = user1.friendHead;
        FriendNode current2 = user2.friendHead;

        System.out.print("Mutual friends between " + user1.name + " and " + user2.name + ": ");
        while (current1 != null) {
            FriendNode temp = current2;
            while (temp != null) {
                if (current1.friendId == temp.friendId) {
                    System.out.print(current1.friendId + " ");
                    break;
                }
                temp = temp.next;
            }
            current1 = current1.next;
        }
        System.out.println();
    }

    void countFriends(int userId) {
        UserNode user = findUser(userId, null);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        int count = 0;
        FriendNode current = user.friendHead;
        while (current != null) {
            count++;
            current = current.next;
        }
        System.out.println(user.name + " has " + count + " friends.");
    }
}

public class SocialMedia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SocialMediaLinkedList socialMedia = new SocialMediaLinkedList();

        while (true) {
            System.out.println("1. Add User");
            System.out.println("2. Add Friend");
            System.out.println("3. Remove Friend");
            System.out.println("4. Display Friends");
            System.out.println("5. Find Mutual Friends");
            System.out.println("6. Count Friends");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter User ID: ");
                int userId = scanner.nextInt();
                scanner.nextLine();  // consume the newline
                System.out.print("Enter User Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter User Age: ");
                int age = scanner.nextInt();
                socialMedia.addUser(userId, name, age);
            } else if (choice == 2) {
                System.out.print("Enter User ID 1: ");
                int userId1 = scanner.nextInt();
                System.out.print("Enter User ID 2: ");
                int userId2 = scanner.nextInt();
                socialMedia.addFriend(userId1, userId2);
            } else if (choice == 3) {
                System.out.print("Enter User ID 1: ");
                int userId1 = scanner.nextInt();
                System.out.print("Enter User ID 2: ");
                int userId2 = scanner.nextInt();
                socialMedia.removeFriend(userId1, userId2);
            } else if (choice == 4) {
                System.out.print("Enter User ID: ");
                int userId = scanner.nextInt();
                socialMedia.displayFriends(userId);
            } else if (choice == 5) {
                System.out.print("Enter User ID 1: ");
                int userId1 = scanner.nextInt();
                System.out.print("Enter User ID 2: ");
                int userId2 = scanner.nextInt();
                socialMedia.findMutualFriends(userId1, userId2);
            } else if (choice == 6) {
                System.out.print("Enter User ID: ");
                int userId = scanner.nextInt();
                socialMedia.countFriends(userId);
            } else if (choice == 7) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
