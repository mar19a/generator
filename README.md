# Generator

<img width="217" alt="Screenshot 2024-03-18 at 9 41 16 PM" src="https://github.com/mar19a/generatorr/assets/84360137/799daa82-4d60-4072-a2f5-a09163d984c9">

Basic Structure: I have the Button, ImageView, and EditText as required, and I've included multiple drawable resources for the images, so that part checks out.


SharedPreferences: I'm using SharedPreferences to save the state when onDestroy() is invoked. This should handle saving the image name and the text from the EditText, aligning with the guidelines.


Restoring State: In the onCreate(..) method, I'm retrieving the saved state from SharedPreferences. This means the app should indeed remember its last state regarding the displayed image and the entered text whenever it's restarted, which is what the guidelines ask for.


Potential SharedPreferences Failures: I understand there are scenarios where SharedPreferences might not restore my app's state correctly, such as if a user clears the app's data, uninstalls the app, there's a device issue, or if there's a problem from updates that clear data. Additionally, if I store too much data or manage SharedPreferences incorrectly (like with concurrent modifications without proper synchronization), that could also lead to issues. I'll keep these limitations in mind for any app developments moving forward.
So, it looks like my app is on the right track according to the provided guidelines! Let me know if there's anything else I should consider or add.
