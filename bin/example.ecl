% ------------- grade_path.ecl -------------
:- lib(ic).             % 區間約束 

% solve_path(-Obj_pre,-Arg_pre,-Obj,-Arg,-Result,-Exception)
% 把 OCL 限制條件轉成 CLP 約束後求解
solve_path(Obj_pre, Arg_pre, Obj, Arg, Result, Exception) :-
        % 1 ️資料模型 ─── 與你先前示例相同
        Obj_pre   = [],                        % 物件呼叫前無屬性需追蹤
        Arg_pre   = [ScorePre],                % 參數 score@pre
        Obj       = [],                        % 物件呼叫後仍無屬性需追蹤
        Arg       = [Score],                   % 參數 score
        Result    = [Number],                  % 函式執行完的 number (= score)
        Exception = [],                        % 本範例無例外

        % 2️ 宣告變數可取值範圍
		Vars = [ScorePre, Score, Number],
        [ScorePre, Score, Number] :: 0 .. 100,
		

        % 3️ 逐條對應 OCL → CLP
        ScorePre #>= 0,        % score@pre ≥ 0
        ScorePre #=< 100,      % score@pre ≤ 100

        Number   #= Score,     % number  = score
        ScorePre #= Score,     % score@pre = score

        Number   #>= 0,        % self.number ≥ 0
        Number   #=< 100,      % self.number ≤ 100

        % 4️ 以 labeling/1 真正產生一組可行值
        (foreach(Var,Vars) 
		do 
		indomain(Var,random)).
		