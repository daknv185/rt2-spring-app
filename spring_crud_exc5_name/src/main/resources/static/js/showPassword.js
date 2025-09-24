const passwordInput = document.getElementById('password-input');
const togglePassword = document.getElementById('toggle-password');

togglePassword.addEventListener('click', function() {
  // パスワード入力欄のタイプを切り替える
  const type = passwordInput.getAttribute('type') === 'password' ? 'text' : 'password';
  passwordInput.setAttribute('type', type);

  // ボタンのテキストを切り替える
  this.textContent = (type === 'password') ? '表示' : '非表示';
});