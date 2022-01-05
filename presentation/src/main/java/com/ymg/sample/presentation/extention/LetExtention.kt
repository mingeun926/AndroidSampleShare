package com.ymg.sample.presentation.extention



inline fun <P1, P2, R> safeLet(p1: P1?, p2: P2?, block: (P1, P2) -> R?): R? {
    return if(p1 != null && p2 != null) {
        block(p1, p2)
    } else {
        null
    }
}

inline fun <P1, P2, P3, R> safeLet(p1: P1?, p2: P2?, p3: P3?, block: (P1, P2, P3) -> R?): R? {
    return if(p1 != null && p2 != null && p3 != null) {
        block(p1, p2, p3)
    } else {
        null
    }
}

inline fun <R> safeEmptyLet(s1: String?, block: (String) -> R?): R? {
    return if (s1 != null && s1.trim().isNotEmpty()) {
        block(s1)
    } else {
        null
    }
}

inline fun <R> safeEmptyLet(s1: String?, s2: String?, block: (String, String) -> R?): R? {
    return if (s1 != null && s1.trim().isNotEmpty() && s2 != null && s2.trim().isNotEmpty()) {
        block(s1, s2)
    } else {
        null
    }
}

inline fun <R> safeEmptyLet(s1: String?, s2: String?, s3: String?, block: (String, String, String) -> R?): R? {
    return if (s1 != null && s1.trim().isNotEmpty() && s2 != null && s2.trim().isNotEmpty() && s3 != null && s3.trim().isNotEmpty()) {
        block(s1, s2, s3)
    } else {
        null
    }
}

inline fun <T1, R> safeEmptyLet(l1: List<T1>?, block: (List<T1>) -> R?): R? {
    return if (!l1.isNullOrEmpty()) {
        block(l1)
    } else {
        null
    }
}

inline fun <T1, T2, R> safeEmptyLet(l1: List<T1>?, l2: List<T2>?, block: (List<T1>, List<T2>) -> R?): R? {
    return if (!l1.isNullOrEmpty() && !l2.isNullOrEmpty()) {
        block(l1, l2)
    } else {
        null
    }
}