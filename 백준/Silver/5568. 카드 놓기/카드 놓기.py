def make_combinations(numbers: list, r: int) -> list: # [] -> [[],[],[],,,,]
    result = []
    #종료
    if r == 0:
        return [[]]

    for i in range(len(numbers)):
        chosen = numbers[i]
        un_chosens = numbers[i + 1:]
        for combos in make_combinations(un_chosens, r - 1):
            result.append([chosen] + combos)

    return result


def make_permutations(numbers: list) -> list: # [] -> [[], [], [], ,,,,,]
    result = []

    if len(numbers) == 0:
        return [[]]

    for i in range(len(numbers)):
        chosen = numbers[i]
        un_chosens = numbers[:i] + numbers[i + 1:]
        for j in make_permutations(un_chosens):
            result.append([chosen] + j)

    return result


def combo_to_string(combo: list) -> str:
    result = ''
    for i in combo:
        result += str(i)

    return result


n = int(input())
k = int(input())

cards = []
unique_numbers = set()
for _ in range(n):
    cards.append(input())

selected_cards_combo = make_combinations(cards, k)
for selected_cards in selected_cards_combo:
    permuted_cards_combo = make_permutations(selected_cards)

    for combo in permuted_cards_combo:
            unique_numbers.add(combo_to_string(combo))


print(len(unique_numbers))

