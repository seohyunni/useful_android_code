....


class InputFilter() : InputFilter {
    override fun filter(source: CharSequence, start: Int, end: Int, dest: Spanned, dstart: Int, dend: Int): CharSequence? {
        val ps = Pattern.compile("^[a-zA-Z0-9ㄱ-ㅎ가-힣ㅏ-ㅣ]+$")

        if (!ps.matcher(source).matches()) {
            return ""
        }
        return null
    }
}

....
