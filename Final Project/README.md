#  Pet Adoption Recommendation App

This JavaFX project is a simple GUI-based application that helps users explore pets, set their preferences, and receive recommendations. It demonstrates the use of **JavaFX layouts, CSS styling, and object-oriented programming principles**.

---

## 🚀 Features
- 🎨  UI with **custom CSS styling** (`style.css`)
- 🐕 Browse different pets with details like:
  - Description
  - Activity level
  - Whether they’re good with kids
- ⚙️ User Preferences:
  - Select activity level
  - Choose if you want a pet that’s kid-friendly
- 💡 Personalized Recommendations based on your choices
- 📂 Organized layouts:
  - Menu
  - Preferences
  - Recommendations

---

## 📸 Screenshot  

![App screenshot](screenshot.png)


## 🧑‍💻 Code Examples

### Pet Class
Each pet has a name, description, activity level, child-friendliness, and an image path.

```
class Pet {
    private final String name;
    private final String description;
    private final int activityLevel;
    private final boolean goodWithKids;
    private final String imagePath;

    public Pet(String name, String description, int activityLevel, boolean goodWithKids, String imagePath) {
        this.name = name;
        this.description = description;
        this.activityLevel = activityLevel;
        this.goodWithKids = goodWithKids;
        this.imagePath = imagePath;
    }

    public String getInfo() {
        return name + " :\n" + description +
                "\nActivity Level: " + activityLevel +
                "\nGood with kids: " + (goodWithKids ? "Yes" : "No");
    }
}
```
