# Repository guide for AI coding assistants

Purpose: give concise, actionable guidance so an AI can make safe, correct edits in this student-oriented Java project.

- Entry point: `Main.java` — do not change. It lists programs from `ProgramLoader.getPrograms()` and calls `selected.run()`.
- Program contract: `core/ProgramInterface.java` — all program classes must implement:
  - `String getName()`, `String getDescription()`, `String getAuthor()`, `void run()`

- Where to add new programs:
  1. Create a new folder under `programs/`, e.g. `programs/yourname/YourProgram.java`.
  2. Copy `TEMPLATE_YourProgram.java` and update package, class name, and the four interface methods.
  3. Register the program in `ProgramLoader.java` by adding one line in `getPrograms()`:
     `programs.add(new programs.yourname.YourProgram());`
     Follow the existing style — keep registration as one constructor call per line.

- Import & package rules to watch for:
  - Canonical interface is `core.ProgramInterface`. Some student files omit the package; prefer adding `import core.ProgramInterface;` and ensure `package programs.<folder>;` is present.
  - Class filename must match public class name and package path (Java rule).

- Build / run (Windows PowerShell examples):
```powershell
javac Main.java
java Main
```
If you edit many files, compile only changed files or use an IDE, but tests and manual runs use the commands above.

- Project conventions & gotchas:
  - Do NOT modify `Main.java` or `core/ProgramInterface.java` — these are shared contracts.
  - `ProgramLoader.java` is intentionally the single registration point; keep changes minimal and additive.
  - Avoid closing shared System.in in `run()` (closing Scanner on System.in can affect other runs). Prefer not to call `sc.close()`.
  - Follow constructive, minimal edits for student submissions (one program per PR, consistent with `STUDENT_GUIDE.md`).

- Developer workflow (from repo docs):
  - Branch naming: `feature/<issue-number>-<short-title>`
  - Base branch for PRs: `develop`
  - See `STUDENT_GUIDE.md` and `QUICK_REFERENCE.md` for full git steps and examples.

- Examples from repo to mirror:
  - Registration: `programs.add(new programs.fibonacci.FibonacciProgram());` (see `ProgramLoader.java`)
  - Template: `TEMPLATE_YourProgram.java` shows required methods and use of Scanner in `run()`.

If anything here is unclear or you want more details (e.g., automated compile checks or sample unit tests), tell me what to expand and I will update this file.
