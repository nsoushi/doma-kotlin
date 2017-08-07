
-- +goose Up
-- SQL in section 'Up' is executed when this migration is applied
CREATE TABLE `tasks` (
  `id`          INT(10)       UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'タスクの識別子',
  `title`       VARCHAR(255)           NOT NULL                COMMENT 'タスクのタイトル',
  `finished_at` DATE                                           COMMENT 'タスクの完了日時',
  `created_at`  DATETIME               NOT NULL,
  `updated_at`  DATETIME               NOT NULL,
  PRIMARY KEY (`id`));

-- +goose Down
-- SQL section 'Down' is executed when this migration is rolled back

