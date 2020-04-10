# C0780996_W2020_MAD3125_MidTerm
## Tax Math
## PROJECT CONTRIBUTORS
Raghav Bobal
## ABOUT PROJECT
1. Created three activities
    a. Splash Screen with Image, Name and Student ID (5 sec)
    b. Details entry screen
    c. Tax details after calculation
2. Created all required files in appropriate packages.
3. Used appropriate views (Material Components) to design UI
4. Used appropriate naming conventions.
5. Applied validation wherever applicable.
6. Used Number formatting and Currency Symbols.

## PROJECT OUTPUT
Screenshot | Description
--- | ---
<img src="https://ibb.co/W6VZSWB" alt="datepicker"/> | Splash screen that lasts 5 seconds.
<img src="https://ibb.co/f0c7tjX" alt="datepicker"/> | Data entry screen for the app. An audio clip plays that asks users to fill the form. Has checks on each field to see if it is empty. Has checks for age and SIN. Date of filing is set to currentdate. Touching date of filing field will bring up a material alert dialog warning the user.
<img src="https://ibb.co/J5Bq0Kw" alt="datepicker"/> | On touching the birthdate field, a date picker pops up.
<img src="https://ibb.co/BzRKhRD" alt="alert"/> | Alert box shows up on clicking the tax filing date field.
<img src="https://ibb.co/QJFH5Zf" alt="errors"/> | Validations for SIN number using regex and age. Buttons disappear if the applicant is not over 18 and displays a warning. TextWatcher removes set errors after text change.
<img src="https://ibb.co/YXM61Br" alt="errors"/> | Valid data entered into the form. Name entry could be in any case and will be displayed in the appropriate format.
<img src="https://ibb.co/hLKmbtf" alt="details1"/> | Activity displaying all the entered as well as calculated information. Implemented Parcelable for data transfer.
## REFERENCES
* [Youtube.com](https://www.youtube.com/watch?v=hwe1abDO2Ag) - Creating a datePicker
* [Android.jlelse.eu](https://android.jlelse.eu/the-complete-android-splash-screen-guide-c7db82bce565) - Creating a splashscreen
* [Stackoverflow.com](https://stackoverflow.com/questions/3646415/how-to-create-edittext-with-rounded-corners) - Creating custom textboxes
* [Joda.org](https://www.joda.org/joda-time/index.html) - Working with Joda-Time
* [Howtodoinjava.org](https://howtodoinjava.com/java/calculate-age-from-date-of-birth/) - Calculating age using Joda
* [Stackoverflow.com](https://stackoverflow.com/questions/20082855/regular-expression-for-canadian-sin-social-insurance-number) - SIN validation regex
* [Sitepoint.com](https://www.sitepoint.com/transfer-data-between-activities-with-android-parcelable/) - Data transfer between activities using parcelable
* [Journaldev.com](https://www.journaldev.com/14748/android-textinputlayout-example) - Working with textfields using Material Design
