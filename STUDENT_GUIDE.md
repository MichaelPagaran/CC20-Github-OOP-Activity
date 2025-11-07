# 🧭 Student Guide — Program Collection

This guide will help you submit your own program while learning how to use Git and GitHub properly.

---

## 🧱 1. Setup

### Clone the Repository
```bash
git clone https://github.com/<teacher-username>/program-collection.git
cd program-collection
```

### Switch to the develop Branch
```bash
git checkout develop
```


## 🪪 2. Create an Issue on GitHub
Open the repository in GitHub.

Go to the Issues tab → click New Issue.

Title example:
Add <YourName> Program (e.g., Add Martin Program)

Briefly describe what your program will do.

Submit the issue.

## 🌿 3. Create a Branch from the Issue
After creating the issue, make a new branch linked to it:
```bash
git fetch origin
git checkout develop
git pull

git checkout -b feature/<issue-number>-<short-title>

# Example:
# git checkout -b feature/12-fibonacci-upgrade
```

## 💾 4. Create Your Program
1. Copy this file:
```
TEMPLATE_YourProgram.java
```
2. Paste it inside a new folder in programs/, example:
```
programs/martin/MyCoolProgram.java
```
3. Edit your file:
- Change the class name
- Update `getName()`, `getDescription()`, `getAuthor()`
- Add your logic in the `run()` method

## 🧩 5. Register Your Program
```java
programs.add(new programs.martin.MyCoolProgram());
```
Do not remove or edit existing entries.

## 🧪 6. Test Your Program
```bash
javac Main.java
java Main
```
You should see your program in the list.
Try selecting it to confirm it works.

## 🚀 7. Commit and Push
``` bash
git add .
git commit -m "Add <YourName> program"
git push origin feature/<issue-number>-<short-title>
```

## 🔁 8. Create a Pull Request (PR)
1. Go to GitHub → You’ll see a banner for your new branch.
2. Click Compare & pull request.
3. Set base branch: develop.
4. Write a short description and link your issue.
5. Click Create pull request.

## 🔄 9. Sync with Latest Code
If the teacher updates the repository, fetch and merge:
```bash
git fetch origin
git checkout develop
git pull
git checkout feature/<your-branch>
git merge develop
``` 

## ✅ 10. After Approval
Once your PR is merged — congratulations! 🎉
Your work becomes part of the official collection.
