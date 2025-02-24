class LegacySystem {
    @Deprecated
    public void oldFeature() {
        System.out.println("This is an old feature and should not be used.");
    }

    public void newFeature() {
        System.out.println("This is the new recommended feature.");
    }
}

public class DeprecatedExample {
    public static void main(String[] args) {
        LegacySystem system = new LegacySystem();
        system.oldFeature();
        system.newFeature();
    }
}
