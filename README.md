# DemoQA Practice – Code Summary

## What the project does

This repository automates the **Elements** section of the DemoQA website using **Selenium WebDriver** and **TestNG**. It follows the Page Object Model (POM) pattern to keep page‑specific actions separate from test logic.

## Step‑by‑step of the code implementation

1. **Project setup**
   - Created a Maven project (`pom.xml`) and added dependencies for Selenium 4.43.0 and TestNG 7.12.0.
2. **Base page‑object classes**
   - For each UI component (Text Box, Check Box, Radio Button) a dedicated class was added under `src/main/java/pageClass/ElementsForm/`.
   - Each class receives a `WebDriver` in its constructor, creates a `WebDriverWait` (10 seconds), a `JavascriptExecutor`, and an `Actions` instance.
   - `PageFactory.initElements(driver, this)` initializes all `@FindBy` elements.
3. **Element locators**
   - Used `@FindBy` annotations (xpath, id, css, className) to locate page elements such as input fields, buttons, and tree nodes.
4. **Navigation methods**
   - Implemented `navigateTo*Menu()` methods that scroll the left navigation panel into view, click the **Elements** heading, then select the specific sub‑section (e.g., "Text Box").
5. **Interaction methods**
   - Added methods to fill inputs (`enterFullName`, `enterFullEmail`, `enterCurrentAddress`, `enterPermanentAddress`).
   - Added a method to click the **Submit** button (`clickSubmit`).
   - For the Check Box page, added methods to expand tree nodes, click specific check boxes, and verify titles.
   - For the Radio Button page (not shown here) similar patterns were followed.
6. **Verification helpers**
   - Methods such as `isResultBoxDisplayed()` and `isEmailErrorDisplayed()` return booleans that the test cases assert against.
7. **Test classes**
   - Created TestNG test classes under `src/test/java/pageTests/ElementsForm/` (e.g., `TextBoxTest.java`).
   - In `@BeforeMethod` a WebDriver instance is created, navigates to `https://demoqa.com`, and instantiates the appropriate page object.
   - Test methods call the page‑object actions and use `Assert` statements to verify outcomes.
   - `@AfterMethod` quits the driver, ensuring each test runs in a fresh browser session.
8. **Running the suite**
   - Executed with `mvn test`. TestNG generates HTML and XML reports in the `test-output/` directory.

## How the code works together
- **Page objects** encapsulate all Selenium interactions for a particular page/section, keeping locators and actions in one place.
- **Test classes** focus purely on the test flow and validation, reusing the page‑object methods.
- The **wait** utility (`WebDriverWait`) ensures elements are interactable before actions are performed, reducing flaky tests.
- **JavaScript scrolling** (`js.executeScript`) is used to bring off‑screen elements into view before clicking.

