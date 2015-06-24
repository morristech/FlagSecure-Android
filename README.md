# FlagSecure-Android
Prevent ScreenCasting data leakage on Android


Android Lollipop has a new feature that allows screen capturing and screen sharing from third party applications. The feature allows third party apps to capture videos from the device and deliver it over the network. However by using the FLAG_SECURE option, one can protect their sensitive screens from third party screen capturing and sharing.

However, if the developers want to protect all the screens of their applications from third party screen capturing and sharing, they need to use this flag in each of the Activities separately. There is no global means to set this flag for all the screens at once. But, one can design their applications in such a way that the FLAG_SECURE needs to be used only once. Below is the code snippet:

> Define a BaseActivity and set the FLAG_SECURE in that Activity :

public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * approach 1: create a base activity and set the FLAG_SECURE in it,
         * Extend all other activities, Fragments from this activity
         */
        getWindow().setFlags(LayoutParams.FLAG_SECURE,
                LayoutParams.FLAG_SECURE);
    }

> Take this BaseActivity as superclass for all the other Activities.

public class LoginActivity extends BaseActivity
public class MainActivity extends BaseActivity

By doing so, when the onCreate() method of the super class is overrriden, the FLAG_SECURE automatically gets set for all the child activities.

> There might be cases where one wants to unset the FLAG_SECURE for some screens. In such cases, in child activity can use the below code:

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            /*
            clear flags: It can be used when user need to enable screen capturing in some applications
             */
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SECURE);
        }
