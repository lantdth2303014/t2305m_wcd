<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <style>
    body {
      display: flex;
      justify-content: center;
      align-items: center;
      flex-direction: column; / Đưa các phần tử xếp theo cột /
    margin: 0;
    / Chiều cao toàn màn hình /
    }
    h1 {
      margin-bottom: 20px; / Khoảng cách giữa tiêu đề và form /
    color: #007BFF; / Màu xanh đồng bộ với nút /
    font-size: 28px;
      text-align: center;
    }
    form {
      display: grid;
      grid-template-columns: 1fr 1.5fr;
      gap: 34px;
      width: 600px;
    }

    input, select {
      padding: 8px;
      box-sizing: border-box;
    / Xóa border /

    outline: none;
    }
    #name {
      width: 100%;
    }
    #email {
      width: 98%;
      grid-column: span 2;
    }
    #phone {
      width: 100%;
    }
    #address {
      width: 60%;
    }
    button {
      padding: 8px 20px;
      background-color: #007BFF;
      color: white;
      border-radius: 4px;
      cursor: pointer;
      width: 30%;
      border: none; / Xóa border /
    }
    button:hover {
      background-color: #0056b3;
    }
    table {
      width: 50%;
      border-collapse: collapse;
      margin-top: 20px;
    / Xóa border của bảng /
    border: none;
    }
    th, td {
      padding: 8px;
      text-align: center;
    / Xóa border của th và td /
    border: none;
    }
    th {
      background-color: #f2f2f2;
    }
    .action-buttons {
      display: flex;
      justify-content: center;
      gap: 10px;
    }
    .action-buttons button {
      padding: 4px 8px;
      font-size: 14px;
      cursor: pointer;
      border: none; / Xóa border /
    }
    .edit-btn {
      background-color: #FFD700;
      color: black;
    }
    .edit-btn:hover {
      background-color: #FFCC00;
    }
    .delete-btn {
      background-color: #FF6347;
      color: white;
    }
    .delete-btn:hover {
      background-color: #FF4500;
    }
  </style>
</head>
<body>
<h1>Player Information</h1>
<form>
  <div>
    <label for="name">Player Name</label>
    <input type="text" id="name" placeholder="name">
  </div>
  <div>
    <label for="email">Player Age</label>
    <input type="email" id="email" placeholder="email">
  </div>
  <div>
    <label for="phone">Index Name</label>
    <select id="phone">
      <option value="a">A</option>
      <option value="b">B</option>
      <option value="c">C</option>
      <option value="d">D</option>
    </select>
  </div>
  <div>
    <label for="address">Value<label>
      <br>
      <input type="number" id="address" placeholder="address">
  </div>
  <button type="submit">Gửi</button>
</form>
<table>
  <thead>
  <tr>
    <th>ID</th>
    <th>Player Name</th>
    <th>Player Age</th>
    <th>Index Name</th>
    <th>Value</th>
    <th>Action </th>
  </tr>
  </thead>
  <tbody>
  <tr>
    <td>1</td>
    <td>John Doe</td>
    <td>25</td>
    <td>speed</td>
    <td>90</td>
    <td class="action-buttons">
      <button class="edit-btn"><a href="editPlayer"></a>Edit</button>
      <button class="delete-btn"><a href="delete"></a>Delete</button>
    </td>
  </tr>
  <tr>
    <td>2</td>
    <td>Jane Smith</td>
    <td>30</td>
    <td>speed</td>
    <td>90</td>
    <td class="action-buttons">
      <button class="edit-btn"><a href="editPlayer"></a>Edit</button>
      <button class="delete-btn"><a href="delete"></a>Delete</button>
    </td>
  </tr>

  </tbody>
</table>
</body>
</html>
