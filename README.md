# Plague's Chat Timestamps

> **The only chat timestamp mod for Forge 1.16.5.**

Adds a configurable timestamp to every chat message so you always know exactly when something was said.

---

## Features

- Prepends a timestamp to every incoming chat message
- Fully configurable format — change the date/time pattern and color
- Lightweight — uses a single Mixin, zero performance impact
- Can be disabled entirely without removing the mod

---

## Installation

1. Make sure you have **Forge 1.16.5** installed
2. Drop `plagues-chat-timestamps-forge-1.0.1.jar` into your `.minecraft/mods` folder
3. Launch the game — the mod works immediately with default settings

---

## Configuration

The mod generates **two config files** in your `.minecraft/config` folder:

### `plagueschattimestamps.toml`

```toml
[general]
    timestamp_format = "&b[dd.MM.yyyy HH:mm:ss] "
    disable_mod = false
```

### `plagueschattimestamps.json`

```json
{
  "enable_mod": true,
  "timestamp_format": "&byyyy.MM.dd HH:mm:ss "
}
```

---

## Changing the Color

Use Minecraft `&` color codes in the format string:

| Code | Color          |
|------|----------------|
| `&0` | Black        |
| `&1` | Dark Blue    |
| `&2` | Dark Green   |
| `&3` | Dark Aqua    |
| `&4` | Dark Red     |
| `&5` | Dark Purple  |
| `&6` | Gold         |
| `&7` | Gray         |
| `&8` | Dark Gray    |
| `&9` | Blue         |
| `&a` | Green        |
| `&b` | Aqua (default)|
| `&c` | Red          |
| `&d` | Light Purple |
| `&e` | Yellow       |
| `&f` | White        |

**Examples:**

```toml
timestamp_format = "&b[HH:mm:ss] "
timestamp_format = "&eHH:mm "
timestamp_format = "&7[dd.MM.yyyy HH:mm:ss] "
timestamp_format = "&6[HH:mm] "
```

---

## Timestamp Format Tokens

| Token  | Meaning         | Example |
|--------|-----------------|---------|
| `HH` | Hour (24h)      | `14`  |
| `mm` | Minutes         | `05`  |
| `ss` | Seconds         | `42`  |
| `dd` | Day             | `03`  |
| `MM` | Month           | `11`  |
| `yyyy` | Year (4 digits) | `2024` |

---

## Building from Source

Requirements: **JDK 8**, **Gradle**

```bash
git clone https://github.com/Morikemuri/plagues-chat-timestamps.git
cd plagues-chat-timestamps
./gradlew build
```

---

## License

MIT

---

## Authors

- **Plague1337** — original concept
- **RuleCore** — Forge 1.16.5 rebuild & patch
- **Gabrielsim** — contributor
- **Amiya** — contributor