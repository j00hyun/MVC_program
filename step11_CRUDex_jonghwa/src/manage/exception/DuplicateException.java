//@version 1.0
/** 
 * PROJECT  : 재고 정리 프로젝트
 * NAME  : DuplicateException.java
 * DESC  :  중복예외 처리용 사용자 정의 예외 클래스
 * 
 * @author  
*/

package manage.exception;

public class DuplicateException extends Exception{

	public DuplicateException() {}
	public DuplicateException(String message) {
		super(message);
	}
}
