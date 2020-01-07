# DisplayApplication


This Library is for various display functionality in android.

The display functionality such as the Toast,AlertDialog,ProgressDialog.
we can use various custom properties in these display functions.

we can implements the library in two ways
1) aar file : add aar file as module dependency
2) implementing : implements in gradle.

For using each display options we have manager class :

for eg:for toast

            ToastManager mbuilder = new ToastManager.Builder().setcontext(PresentContext).build();

Like this we can build each managers.

We have Dialog manager for normal dialog and MaterialDialogManager for a Predefined materialdialog which can change its color images texts etc.


   For showing and dismissing we have seperate methods.

   for eg: managerobject.show(); here  for toast mbuilder.showToast();

  Implementing additional properties  simply  add the method before build.
  for eg:   
              ToastManager mbuilder = new ToastManager.Builder().setcontext(PresentContext).setMessage("hello       
              user").setDuration(1).setDrawable(R.drawable.iconfinder_star_227558).setGravity((Gravity.FILL_HORIZONTAL)).build();




