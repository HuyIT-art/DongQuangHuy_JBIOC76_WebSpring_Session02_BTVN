# Task Management RESTful API Design

## Description

Hệ thống quản lý Task (Công việc) và User (Người dùng).

- Mỗi Task thuộc về một User.
- Liên kết giữa Task và User được thực hiện thông qua `userId`.

---

# User APIs

## 1. Get all users

### Endpoint

```http
GET /users
```

### Description

Lấy toàn bộ danh sách người dùng.

### Response

```json
[
  {
    "id": 1,
    "name": "Huy",
    "email": "huy@gmail.com",
    "role": "admin"
  }
]
```

---

## 2. Create user

### Endpoint

```http
POST /users
```

### Request Body

```json
{
  "name": "Huy",
  "email": "huy@gmail.com",
  "role": "user"
}
```

### Validation

- name không được rỗng
- email đúng định dạng
- role chỉ nhận `admin` hoặc `user`

### Response

```json
{
  "message": "User created successfully"
}
```

---

## 3. Update user role

### Endpoint

```http
PATCH /users/{id}/role
```

### Example

```http
PATCH /users/1/role
```

### Request Body

```json
{
  "role": "admin"
}
```

### Response

```json
{
  "message": "User role updated successfully"
}
```

---

## 4. Delete user

### Endpoint

```http
DELETE /users/{id}
```

### Example

```http
DELETE /users/1
```

### Response

```json
{
  "message": "User deleted successfully"
}
```

---

## 5. Get tasks of a user

### Endpoint

```http
GET /users/{id}/tasks
```

### Example

```http
GET /users/1/tasks
```

### Description

Lấy toàn bộ công việc của một người dùng.

### Response

```json
[
  {
    "id": 1,
    "title": "Learn Spring Boot",
    "priority": "high",
    "status": "doing",
    "userId": 1
  }
]
```

---

# Task APIs

## 6. Get all tasks

### Endpoint

```http
GET /tasks
```

### Description

Lấy toàn bộ danh sách công việc.

### Response

```json
[
  {
    "id": 1,
    "title": "Learn Spring Boot",
    "priority": "high",
    "status": "todo",
    "userId": 1
  }
]
```

---

## 7. Create task

### Endpoint

```http
POST /tasks
```

### Request Body

```json
{
  "title": "Learn Spring Boot",
  "priority": "high",
  "status": "todo",
  "userId": 1
}
```

### Validation

- title không được rỗng
- priority chỉ nhận `low`, `medium`, `high`
- status chỉ nhận `todo`, `doing`, `done`
- userId phải tồn tại trong hệ thống

### Response

```json
{
  "message": "Task created successfully"
}
```

---

## 8. Update task status

### Endpoint

```http
PATCH /tasks/{id}/status
```

### Example

```http
PATCH /tasks/1/status
```

### Request Body

```json
{
  "status": "done"
}
```

### Response

```json
{
  "message": "Task status updated successfully"
}
```

---

## 9. Delete task

### Endpoint

```http
DELETE /tasks/{id}
```

### Example

```http
DELETE /tasks/1
```

### Response

```json
{
  "message": "Task deleted successfully"
}
```

---

## 10. Find tasks with high priority

### Endpoint

```http
GET /tasks?priority=high
```

### Description

Tìm tất cả công việc có độ ưu tiên là `high`.

### Response

```json
[
  {
    "id": 1,
    "title": "Learn Spring Boot",
    "priority": "high",
    "status": "doing",
    "userId": 1
  }
]
```

---

## 11. Find high priority tasks of user id = 1

### Endpoint

```http
GET /tasks?priority=high&userId=1
```

### Description

Tìm công việc có độ ưu tiên `high` và được giao cho user có id = 1.

### Response

```json
[
  {
    "id": 1,
    "title": "Learn Spring Boot",
    "priority": "high",
    "status": "doing",
    "userId": 1
  }
]
```

---

## 12. Assign task to user

### Endpoint

```http
PATCH /tasks/{taskId}/assign
```

### Example

```http
PATCH /tasks/1/assign
```

### Request Body

```json
{
  "userId": 2
}
```

### Description

Gán công việc cho một người dùng khác.

### Response

```json
{
  "message": "Task assigned successfully"
}
```