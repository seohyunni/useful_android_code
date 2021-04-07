
// when touch areas out of keyboard, hide keyboard feature

//in fragment
class HideKeyboardFragment() : Fragment() {

  private lateinit var viewDataBinding: FragmentHideKeyboard
  ...

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {  //This code must be in OnCreateView
        viewDataBinding.layoutId.setOnTouchListener(object : View.OnTouchListener {  //layoutId is a whole layout which covering the another layout(First create layout ex:ConstraintLayout ...etc)
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                val inputMethodManager = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(activity?.currentFocus?.windowToken, 0)
                return false
            }
        })
  }
  ...
}


//in activity
class HideKeyboardActivity : AppCompatActivity() {

  private lateinit var viewDataBinding: ActivityHideKeyboard
  ...

  override fun onCreate(savedInstanceState: Bundle?) {//This code must be in onCreate
      viewDataBinding.layoutId.setOnTouchListener(object : View.OnTouchListener {  //layoutId is a whole layout which covering the another layout(First create layout ex:ConstraintLayout ...etc)
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
                return false
            }
        })
  }
  ...
}


